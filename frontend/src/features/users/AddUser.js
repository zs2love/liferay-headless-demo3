import React, { useState } from 'react'
import { useDispatch, useSelector } from 'react-redux'
import { Button ,Input, Form, Select} from 'antd';
import { unwrapResult } from '@reduxjs/toolkit'


export const AddUser = () => {

    const [id, seId] = useState('')
    const [name, setName] = useState('')
    const [addRequestStatus, setAddRequestStatus] = useState('idle')

    const dispatch = useDispatch()
    const users = useSelector(state => state.users).users

    const onIdChanged = e => seId(e.target.value)
    const onNameChanged = e => setName(e.target.value)
    const canSave = [id,name].every(Boolean)
    const layout = {
        labelCol: { span: 2 },
        wrapperCol: { span: 16 },
    };
    const tailLayout = {
        wrapperCol: { offset: 8, span: 16 },
    };
    const onSaveUserClicked = ()=>{

    }
    return (
    <section>
        <h2>添加新用户</h2>
        <Form {...layout} 
        labelCol={{ span: 2 }}
        wrapperCol={{ span: 16 }}>
        <Form.Item
            label="Id"
            name="id"
            rules={[{ required: true, message: 'Please input id!' }]} >
            <Input 
            type="text"
            name="id"
            value={id}
            onChange={onIdChanged}/>
        </Form.Item>
        
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
        
        <Form.Item {...tailLayout}>
            <Button  type="primary" onClick={onSaveUserClicked} disabled={!canSave}>
            Save Post
            </Button>
        </Form.Item>
        </Form>
    </section>
    )
}