'use strict';

import React, { useState, useEffect } from 'react';
import {NavLink} from "react-router-dom";
import './card.css'
import busStop from './bus-stop.svg';
import bus from './bus.svg';
const Card = (props) => {
    let title = props.flag === undefined ?
        <NavLink className='detailLink' to  = {{
            pathname: `/busDetail/${props.title}`,
            state:{
                title: props.title
            }
        }}>
            <div>{props.title}</div>
        </NavLink>
        :
        <div>{props.title}</div>
    let arrTime = props.arrTime === undefined ? '' : <div className='arrTime'>{props.arrTime}</div>

    return(
        <div className='cardRoot'>
            <img className='busImg' src ={props.flag === undefined ? busStop : bus}/>
            <div className='cardTop'>
                <div className='cardTitle'>
                    {title}
                </div>
                {arrTime}
            </div>

        </div>
    )
}
export default Card