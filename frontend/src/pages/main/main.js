'use strict';

import React, { useEffect } from 'react';
import Card from '../../component/card/card';
import './main.css';
const Main = () => {
    let cardList = [
        {'title':'춘천역환승센터','stop':['남춘천역','춘천역']},{'title':'한림대학교','stop':['남춘천역','춘천역']},
        {'title':'강원대학병원','stop':['남춘천역','춘천역']},{'title':'강원대후문','stop':['남춘천역','춘천역']},
        {'title':'강원대중앙도서관','stop':['남춘천역','춘천역']},{'title':'강원대백록관','stop':['남춘천역','춘천역']},
        {'title':'강원대정문','stop':['남춘천역','춘천역']},{'title':'병무청앞','stop':['남춘천역']},
        {'title':'법원','stop':['남춘천역','춘천역']},{'title':'남춘천역종점','stop':['남춘천역']},
        {'title':'남춘천역환승센터','stop':['남춘천역']},{'title':'시외버스터미널','stop':['춘천역']}
    ];
    return(
        <div>
            <div className='mainTitle'>
                강원대학교 300번 버스 알림이
            </div>
            <div className='mainContent'>
                {
                    cardList.map((card, i) => {
                        return(<Card obj={card} key = {i}></Card>)
                    })
                }
            </div>
        </div>
    )
}
export default Main