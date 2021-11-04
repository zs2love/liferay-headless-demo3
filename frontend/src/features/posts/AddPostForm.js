import React, { useState } from 'react'
import { useDispatch, useSelector } from 'react-redux'
import { Button ,Input, Form, Select} from 'antd';
import { postAdded } from './postSlice'
export const AddPostForm = () => {
  const { Option } = Select;
  const [title, setTitle] = useState('')
  const [content, setContent] = useState('')
  const [userId, setUserId] = useState('')
  const [addRequestStatus, setAddRequestStatus] = useState('idle')

  const dispatch = useDispatch()
  const users = useSelector(state => state.users).users

  const onTitleChanged = e => setTitle(e.target.value)
  const onContentChanged = e => setContent(e.target.value)
  const onAuthorChanged = e =>  setUserId(e)
  
  const canSave = [title, content, userId].every(Boolean) && addRequestStatus === 'idle'
  // const onSavePostClicked = async () => {
  //   if (canSave) {
  //     dispatch( postAdded(title, content, userId))
  //     setTitle('')
  //     setContent('')
  //   }
  // }
  const onSavePostClicked = async () => {
    if (canSave) {
      try {
        // setAddRequestStatus('pending')
        // const resultAction = await dispatch(
        //   addNewPost({ title, content, user: userId })
        // )
        // unwrapResult(resultAction)
       await dispatch( postAdded(title, content, userId))
        setTitle('')
        setContent('')
        setUserId('')
      } catch (err) {
        console.error('Failed to save the post: ', err)
      } finally {
        setAddRequestStatus('idle')
      }
    }
  }
 
  
  const usersOptions = users.map(user=>(
      <Option  key={user.id} value = {user.id}> {user.name}</Option>    
  ))
  const layout = {
    labelCol: { span: 2 },
    wrapperCol: { span: 16 },
  };
  const tailLayout = {
    wrapperCol: { offset: 8, span: 16 },
  };
 
  return (
    <section>
      <h2>添加新帖子</h2>
      <Form {...layout} 
        labelCol={{ span: 2 }}
        wrapperCol={{ span: 16 }}>
        <Form.Item
          label="title"
          name="title"
          rules={[{ required: true, message: 'Please input title!' }]} >
          <Input 
            type="text"
            name="postTitle"
            value={title}
            onChange={onTitleChanged}/>
        </Form.Item>
        <Form.Item 
         label="Author"
         name="Author"
         rules={[{ required: true }]} >
          <Select value={ userId } onChange={onAuthorChanged}
            placeholder="Select a option and change input text above"
            allowClear >
             <Option value=""></Option>
             {usersOptions}
          </Select>
        </Form.Item>
        <Form.Item 
          label="content"
          name="content"
          rules={[{ required: true, message: 'Please input content!' }]}>
          <Input
            id="postContent"
            name="postContent"
            value={content}
            onChange={onContentChanged}
          />
        </Form.Item>
       
        <Form.Item {...tailLayout}>
          <Button  type="primary" onClick={onSavePostClicked} disabled={!canSave}>
            Save Post
          </Button>
        </Form.Item>
      </Form>
    </section>
  )
}