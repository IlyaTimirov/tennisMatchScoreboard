<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Моя первая страница</title>
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        body{
            background-image: url('back.jpg');
            color: white;
        }
        header{
            display: flex;
            flex-direction: row;
            flex-wrap: wrap;
            justify-content: center;
        }
        .container, form{
            margin: auto;
            display: flex;
            flex-direction: column;
            flex-wrap: wrap;
        }
        .logo, .top_menu{
            display: inline-block;
        }
        .top_menu li{
            display: inline-block;

        }
        a{
            display: block;
            width: 200px;
            height: 40px;
            line-height: 40px;
            font-size: 18px;
            font-family: sans-serif;
            text-decoration: none;
            color: olivedrab;
            border: 2px solid olivedrab;
            letter-spacing: 2px;
            text-align: center;
            transition: all .35s;
        }

        a:hover{
            color: white;
        }

        a:hover:after{
            width: 100%;
        }

        form{
            display: flex;
            justify-content: center;
        }


        .custom-btn {
            display: inline-block;
            width: 200px;
            height: 40px;
            color: #fff;
            border-radius: 5px;
            padding: 10px 25px;
            font-family: 'Lato', sans-serif;
            font-weight: 500;
            background: transparent;
            cursor: pointer;
            transition: all 0.3s ease;
            position: relative;
            box-shadow:inset 2px 2px 2px 0px rgba(255,255,255,.5),
            7px 7px 20px 0px rgba(0,0,0,.1),
            4px 4px 5px 0px rgba(0,0,0,.1);
            outline: none;
        }
        .btn-7 {
            background: linear-gradient(0deg, rgba(255,151,0,1) 0%, rgba(251,75,2,1) 100%);
            line-height: 42px;
            padding: 0;
            border: none;
        }
        .btn-7 span {
            position: relative;
            display: block;
            width: 100%;
            height: 100%;
        }
        .btn-7:before,
        .btn-7:after {
            position: absolute;
            content: "";
            right: 0;
            bottom: 0;
            background: rgba(251,75,2,1);
            box-shadow:
                    -7px -7px 20px 0px rgba(255,255,255,.9),
                    -4px -4px 5px 0px rgba(255,255,255,.9),
                    7px 7px 20px 0px rgba(0,0,0,.2),
                    4px 4px 5px 0px rgba(0,0,0,.3);
            transition: all 0.3s ease;
        }
        .btn-7:before{
            height: 0%;
            width: 2px;
        }
        .btn-7:after {
            width: 0%;
            height: 2px;
        }
        .btn-7:hover{
            color: rgba(251,75,2,1);
            background: transparent;
        }
        .btn-7:hover:before {
            height: 100%;
        }
        .btn-7:hover:after {
            width: 100%;
        }
        .btn-7 span:before,
        .btn-7 span:after {
            position: absolute;
            content: "";
            left: 0;
            top: 0;
            background: rgba(251,75,2,1);
            box-shadow:
                    -7px -7px 20px 0px rgba(255,255,255,.9),
                    -4px -4px 5px 0px rgba(255,255,255,.9),
                    7px 7px 20px 0px rgba(0,0,0,.2),
                    4px 4px 5px 0px rgba(0,0,0,.3);
            transition: all 0.3s ease;
        }
        .btn-7 span:before {
            width: 2px;
            height: 0%;
        }
        .btn-7 span:after {
            height: 2px;
            width: 0%;
        }
        .btn-7 span:hover:before {
            height: 100%;
        }
        .btn-7 span:hover:after {
            width: 100%;
        }
    </style>
</head>
<body>
<header>
    <div class="All_header_menu">
        <div class="logo">
            <h1>Hello World!</h1>
        </div>
        <div class="top_menu">
            <ul>
                <li><a href="matches?page=1">Завершеные матчи</a></li>
                <li><a href="home">Главная</a></li>
            </ul>
        </div>
    </div>
</header>
<div class="container">
    <form action="new-match" method="post" enctype="application/x-www-form-urlencoded">
        <label>Введите имя первого игрока: <input type="text" name="player1" required/></label>
        <label>Введите имя второго игрока: <input type="text" name="player2" required/></label>
        <button class="custom-btn btn-7"><span>Новая игра</span></button>
    </form>
</div>
</body>
</html>