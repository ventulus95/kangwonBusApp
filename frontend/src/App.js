
import React, { Component } from 'react';
import {BrowserRouter, Route} from 'react-router-dom';
import Main from './pages/main/main';
import DetailContent from './pages/detailContent/detailContent'
const App = () =>(
    <BrowserRouter>
        <div>
            <Route exact path = "/" component={Main}/>
            <Route path = "/busDetail/:busTitle" component= {DetailContent}/>
        </div>
    </BrowserRouter>
)
export default App;