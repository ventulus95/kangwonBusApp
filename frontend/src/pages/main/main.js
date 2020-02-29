'use strict';

import React, { useEffect } from 'react';
import Card from '../../component/card/card';
import './main.css';
const Main = () => {
    let cardList = [
        '춘천역환승센터','한림대학교','강원대학병원','강원대후문',
        '강원대중앙도서관','강원대백록관','강원대정문','병무청앞',
        '법원','남춘천역종점','남춘천역환승센터'
    ];
    return(
        <div>
            <div className='mainTitle'>
                강원대학교 300번 버스 알림이
            </div>
            <div className='mainContent'>
                {
                    cardList.map((card, i) => {
                        return(<Card title={card} key = {i}></Card>)
                    })
                }
            </div>
        </div>
    )
}
export default Main