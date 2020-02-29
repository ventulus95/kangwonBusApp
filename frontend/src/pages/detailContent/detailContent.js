'use strict';

import React, { useEffect, useState } from 'react';
import axios from 'axios';
import arrow from './left-arrow.svg'
import Card from "../../component/card/card";
import './detailContent.css'
const DetailContent = (props) => {
    let [sArrTime, setSArr] = useState('');
    let [nArrTime, setNArr] = useState('');
    const setTime = (flag, location) => {
        let url = '/busStop/' + flag + ' 방향 '+ location
        let setFunc = flag === '남춘천역' ? setSArr : setNArr;
        console.log(url)
        axios.get(url,).then(res => {
            if(res.data.arrtime){
                setFunc(res.data.arrtime+ '분 남음');
            }else{
                setFunc('알 수 없음');
            }
        })
    }
    useEffect(() =>{
        setTime('남춘천역', props.location.state.title);
        setTime('춘천역', props.location.state.title);
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
            <Card title = '남춘천역 방향' arrTime = {sArrTime} flag = 'bus'/>
            <Card title = '춘천역 방향'   arrTime = {nArrTime} flag = 'bus'/>
        </div>
    )
}
export default DetailContent