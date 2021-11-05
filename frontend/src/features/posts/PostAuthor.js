import React, { useState } from 'react'
import { useDispatch, useSelector } from 'react-redux'
import { Button ,Input, Form, Select} from 'antd';
import { addNewPost } from './postSlice'

export const PostAuthor = ({ userId }) => {
  const [age, setAge] = useState('')
  const [name, setName] = useState('')
  const [fileName, setFileName] = useState('')
  const [gender, setGender] = useState('')
  const [addRequestStatus, setAddRequestStatus] = useState('idle')
  const { Option } = Select;
  const dispatch = useDispatch()
  const onAgeChanged = e => setAge(e.target.value)
  const onNameChanged = e => setName(e.target.value)
  const onFileNameChanged = e =>  setFileName(e.target.value)
  const onGenderChanged = e => setGender(e)

  const onSavePostClicked = async () => {
    
      try {
        // setAddRequestStatus('pending')
        // const resultAction = await dispatch(
        //   addNewPost({ title, content, user: userId })
        // )
        // unwrapResult(resultAction)
        const  params = { age, name, fileName, gender} ;
        console.log(params)
        await dispatch( addNewPost(params))
         
      } catch (err) {
        console.error('Failed to save the post: ', err)
      } finally {
        setAddRequestStatus('idle')
      }
    
  }
  const layout = {
    labelCol: { span: 2 },
    wrapperCol: { span: 16 },
  };
  const tailLayout = {
    wrapperCol: { offset: 8, span: 16 },
  };
  return(
    <section>
      <h2>查询</h2>
      <Form {...layout} 
       >
       <Form.Item 
          label="name"
          name="name"
          rules={[{ required: true, message: 'Please input name!' }]}>
          <Input
            id="name"
            name="name"
            value={name}
            onChange={onNameChanged}
          />
        </Form.Item>
        <Form.Item 
          label="fileName"
          name="fileName"
          rules={[{ required: true, message: 'Please input fileName!' }]}>
          <Input
            id="fileName"
            name="fileName"
            value={fileName}
            onChange={onFileNameChanged}
          />
        </Form.Item>
        <Form.Item
          label="age"
          name="age"
          rules={[{ required: true, message: 'Please input age!' }]} >
          <Input 
            type="text"
            name="age"
            value={age}
            onChange={onAgeChanged}/>
        </Form.Item>
        <Form.Item 
         label="gender"
         name="gender"
         rules={[{ required: true }]} >
          <Select value={ gender } onChange={onGenderChanged}
            placeholder="Select a option and change input text above"
            allowClear >
            <Option  key='0' value = '0'> 男</Option> 
            <Option  key='1' value = '1'> 女</Option> 
          </Select>
        </Form.Item>
        <Form.Item {...tailLayout}>
          <Button  type="primary" onClick={onSavePostClicked}>
            Save Post
          </Button>
        </Form.Item>
      </Form>
    </section>
  )
  
  
}