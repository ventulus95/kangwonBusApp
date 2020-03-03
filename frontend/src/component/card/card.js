'use strict';

import React, { useState, useEffect } from 'react';
import {NavLink} from "react-router-dom";
import './card.css'
import busStop from './bus-stop.svg';
import bus from './bus.svg';
const Card = (props) => {
    let title = props.flag === undefined ?
        <NavLink className='detailLink' to  = {{
            pathname: `/busDetail/${props.obj.title}`,
            state:{
                title: props.obj.title,
                stop: props.obj.stop
            }
        }}>
            <div>{props.obj.title}</div>
        </NavLink>
        :
        <div>{props.obj.title}</div>
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