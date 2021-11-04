import React, { useEffect } from 'react'
import { useSelector, useDispatch } from 'react-redux'
import { Link } from 'react-router-dom'
import { AddUser } from './AddUser'
import { Button ,Card} from 'antd';

export const UsersPage = () => {
    const users = useSelector(state => state.users).users
    const userList = users.map(user => (
        <div className="site-card-border-less-wrapper" key={user.id}>
          <Card  title={user.name}  bordered={false} style={{ width: 300 }}>
           <p>{user.name}</p>
           
          </Card>
        </div>
    ))
    return(
        <div>
            <AddUser />
            <h3>用户列表</h3>
            {userList}
        </div>
       
    )
}