import "../styles/header.scss"
import React from 'react'
import { useNavigate, Link } from "react-router-dom"


const Header = () => {
    return (
        <div className="header-wrapper">
            <div className="header-title">
                <Link to="/">
                    <span>SV-BOARD</span>
                </Link>
            </div>
            <div className="header-menu">
                <Link to="/">게시판</Link>
                <Link to="/">글쓰기</Link>
            </div>
        </div>
    )
}

export default Header;