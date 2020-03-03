'use strict';

import React, { useEffect, useState } from 'react';
import axios from 'axios';
import arrow from './left-arrow.svg'
import Card from "../../component/card/card";
import './detailContent.css'
const DetailContent = (props) => {
    let [cardArray,setCard] = useState([]);
    const setTime = (flag, location) => {
        let url = '/busStop/' + flag + ' 방향 '+ location
        console.log(url)
        axios.get(url,).then(res => {
            if(res.data.arrtime){
                setCard(oldArr => [...oldArr,
                    <Card obj     = {{'title':`${flag} 방향`,'stop':[]}}
                          arrTime = {res.data.arrtime+'분 남음'}
                          flag    = 'bus'
                          key     = {oldArr.length}/>
                ])
            }else{
                setCard(oldArr => [...oldArr,
                    <Card obj     = {{'title':`${flag} 방향`,'stop':[]}}
                          arrTime = {'알 수 없음'}
                          flag    = 'bus'
                          key     = {oldArr.length}/>
                ])
            }
        })
    }
    useEffect(() =>{
        console.log(props.location.state.stop)
        props.location.state.stop.map(stop => {
            setTime(stop, props.location.state.title);
        })
    },[])
    return(
        <div className='detailRoot'>
            <div className='detailTop'>
                <img className = 'back'  src = {arrow} onClick = {()=> {
                    props.history.goBack()
                }}/>
                <div className='detailTitle'>
                    {props.location.state.title}
                </div>
            </div>
            {cardArray}
        </div>
    )
}
export default DetailContent