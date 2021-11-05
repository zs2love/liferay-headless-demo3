import { createSlice, nanoid, createAsyncThunk, createSelector } from '@reduxjs/toolkit'

import { get, post } from '../../api/axios'
import { getMockEndpoint , getEndpoint} from '../../api/config'

const initialState = {
  posts: [
    ],
  status: 'idle',
  error: null
}

export const fetchPosts = createAsyncThunk('posts/fetchPosts', async (params) => {

  //const response = await client.get('/fakeApi/posts')
  const response = await get(getEndpoint('get_list') + params)
  console.log(response.data)
  return  response.data.posts;
})
export const addNewPost = createAsyncThunk('posts/addNewPost', async initialPost => {
    const response = await post(getEndpoint('post_fake'), initialPost)
    // The response includes the complete post object, including unique ID
    return response.posts;
  }
)

export const addFile = createAsyncThunk('posts/addFile', async initialPost => {
console.log('initialPost  ')
console.log(initialPost)
  const formData = new FormData();
  formData.append('open_id_csv',initialPost)
  const response = await post('https://wechat-sit-cms-dot-gweb-china-test.an.r.appspot.com/upload/openIdCSV', formData)
  // The response includes the complete post object, including unique ID
  return response.posts;
}
)

const postsSlice = createSlice({
  name: 'posts',
  initialState,
  reducers: {
    postAdded: {
      reducer(state, action) {
        state.posts.push(action.payload)
      },
      prepare(title, content, userId) {
        return {
          payload: {
            id: nanoid(),
            date: new Date().toISOString(),
            title,
            content,
            user: userId,
          },
        }
      },
    },

    postUpdated(state,action) {
      const {id, title, content } = action.payload;
      const postItem = state.posts.find(post =>post.id === id);
      if( postItem ){
        postItem.title = title
        postItem.content = content
      }
    }
  },
  extraReducers: {
    [fetchPosts.pending]: (state, action) => {
      console.log('loading')
      state.status = 'loading'
    },
    [fetchPosts.fulfilled]: (state, action) => {
      state.status = 'succeeded'
      console.log('succeeded')
      console.log(action)
      state.posts = state.posts.concat(action.payload)
    },
    [fetchPosts.rejected]: (state, action) => {
      console.log('failed')
      state.status = 'failed'
      state.error = action.error.message
    },
    [addNewPost.fulfilled]: (state, action) => {
      // We can directly add the new post object to our posts array
      state.posts.push(action.payload)
    },
    [addFile.fulfilled]: (state, action) => {
      // We can directly add the new post object to our posts array
      console.log('succeeded')
    }
  }
})
export const { postAdded, postUpdated} = postsSlice.actions

export default postsSlice.reducer

export const selectAllPosts = state => state.posts

export const selectPostById = (state, postId) =>
  state.posts.posts.find(post => post.id === postId)

export const selectPostsByUser = createSelector(
  [selectAllPosts, (state, userId) => userId],
  (posts, userId) => posts.filter(post => post.user === userId)
)