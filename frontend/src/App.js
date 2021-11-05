
import React from 'react';
import  Home  from './features/home';
import { PostsList } from './features/posts/PostsList';
import { AddPostForm } from './features/posts/AddPostForm';
import { PostAuthor } from './features/posts/PostAuthor'
import { SinglePostPage } from './features/posts/SinglePostPage';
import { EditPostForm } from './features/posts/EditPostForm';
import { UsersPage } from './features/users/UsersPage';
import {
  BrowserRouter as Router,
  Route,
  Switch,
} from "react-router-dom";

function App() {
  return (
    <div className="App">
      <Router>
        <Switch>
          <Route exact path="/" component={Home} />
          <Route exact path="/post" render={() => (
              <React.Fragment>
                <AddPostForm />
                <PostsList />
              </React.Fragment>
            )} />
          <Route exact path="/post/:postId" component={SinglePostPage} />
          <Route exact path="/post/edit/:postId" component={EditPostForm} />
          <Route exact path="/user" component={UsersPage} />
          {/* 精准匹配exact 
          <Route exact path="/mine/:id?/:name?" component={Mine} /> // 问号非必传，否则404
          {/* 更精准匹配exact strict 
          <Route exact strict path="/about" component={About} />
          <Route exact strict path="/shop" component={Shop} />
          {/* 简形式 
          <Route path="/demo" render={() => <div>demo</div>} />
          {/* 重定向 
          <Redirect from="/my" to="mine" /> */}
          
        </Switch>
      </Router>
    </div>
  );
}

export default App;
