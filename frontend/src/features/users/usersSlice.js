
import { createSlice, createAsyncThunk } from '@reduxjs/toolkit'
import { get ,post} from '../../api/axios'



export const fetchUsers = createAsyncThunk('users/fetchUsers', async () => {
  const response = await get('/mo/users')
  return response.data
})


const initialState = {
  users: [
    { id: '0', name: 'Tianna Jenkins' },
    { id: '1', name: 'Kevin Grant' },
    { id: '2', name: 'Madison Price' }
    ],
  status: 'idle',
  error: null
}
export const fetchaddNewUser = createAsyncThunk('posts/addNewPost', async initialPost => {
  const response = await post('/fakeApi/posts', { post: initialPost })
  // The response includes the complete post object, including unique ID
  return response.users;
})

const usersSlice = createSlice({
  name: 'users',
  initialState,
  reducers: {

  },
  extraReducers(builder) {
    builder.addCase(fetchUsers.fulfilled, (state, action) => {
      return action.payload
    });
    builder.addCase(fetchaddNewUser.fulfilled, (state, action) => {
      state.users.push(action.payload)
    });
  },
  // extraReducers:{
  //   [addNewUser.fulfilled]: (state, action) => {
     
  //     state.users.push(action.payload)
  //   }

  // }
})

export default usersSlice.reducer