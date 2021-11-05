import React, { useEffect, useState } from 'react'
import { useSelector, useDispatch } from 'react-redux'
import { Link } from 'react-router-dom'
import { selectAllPosts, fetchPosts, addFile} from './postSlice'
import { Upload, message, Button , Card} from 'antd';
import { UploadOutlined } from '@ant-design/icons';
import './post.css';
import {useLocation} from 'react-router-dom';

import { PostAuthor } from './PostAuthor'

export const PostsList = ({ match }) => {
  const dispatch = useDispatch()
  const posts =  useSelector(selectAllPosts).posts
  const postStatus = useSelector(state => state.posts.status)
  const location = useLocation();
  const searchKey = location.state.id;

  useEffect(() => {
    console.log(searchKey)
    if (postStatus === 'idle') {
      dispatch(fetchPosts(searchKey))
    }
  })
  const [fileList, setFileList] = useState([])

  const renderedPosts = posts.map(post => (
    <div className="site-card-border-less-wrapper" key={post.id}>
      <Card  title={post.title}  bordered={false} style={{ width: 300 }}>
        <p className="post-content">{post.content.substring(0, 100)}</p>
        <div>
          <Link to={`/post/${post.id}`} className="button muted-button">
          View Post
          </Link>
        </div>
        <div>
          <Link to={`/post/edit/${post.id}`} className="button">
            Edit Post
          </Link>
        </div>
      </Card>
    </div>
   
  ))
  const props = {
    name: 'file',
    action: '',
    onChange(info) {
      console.log(info)
      dispatch( addFile(info.file))
      if (info.file.status !== 'uploading') {
        console.log(info.file, info.fileList);
      }
      if (info.file.status === 'done') {
        message.success(`${info.file.name} file uploaded successfully`);
      } else if (info.file.status === 'error') {
        message.error(`${info.file.name} file upload failed.`);
      }
    },
    beforeUpload: file => {
      setFileList (
        [...fileList, file],
      );
      return false;
    },
    fileList,
  };

  return (
    <section className="posts-list">
      <h2>Posts</h2>
      <Upload {...props}>
        <Button icon={<UploadOutlined />}>Click to Upload</Button>
      </Upload>
   
      <PostAuthor />
      {renderedPosts}
    </section>
  )
}
