
import './home.css';
import React, { useState } from 'react'
import { Button ,Input, Form, Select} from 'antd';
import { useHistory } from 'react-router-dom'
function Home(props) {
  const [key, setKey] = useState('')
  const onKeyChanged = e => setKey(e.target.value)
  const history = useHistory()
  return (
    <div className="home">
    <Form  labelCol= {{ span: 2 }}  wrapperCol={{ span: 8 }}>
      <Form.Item
            label="key"
            name="searchKey"
              rules={[{ required: true, message: 'Please input searchKey!' }]} >
        <Input type="searchKey"
                name="searchKey"
                value={key}
                onChange={onKeyChanged}  />
        
        <Button onClick={() => history.push({pathname: "/post", state: {id: key} }) }>
          click
        </Button>
      </Form.Item>
    </Form>
    </div>
  );
}

export default Home;