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
        //background-repeat: no-repeat;
        //background-size: cover;
            color: white;
        }
        header{
            display: flex;
            flex-direction: row;
            flex-wrap: wrap;
            justify-content: center;
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

        .table_dark {
            font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif, serif;
            font-size: 14px;
            width: 640px;
            text-align: left;
            border-collapse: collapse;
            background: #252F48;
            margin: 10px;
        }
        .table_dark th {
            color: #EDB749;
            border-bottom: 1px solid #37B5A5;
            padding: 12px 17px;
        }
        .table_dark td {
            color: #CAD4D6;
            border-bottom: 1px solid #37B5A5;
            border-right:1px solid #37B5A5;
            padding: 7px 17px;
        }
        .table_dark tr:last-child td {
            border-bottom: none;
        }
        .table_dark td:last-child {
            border-right: none;
        }
        .table_dark tr:hover td {
            text-decoration: underline;
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

        .buttons {
            display: flex;
            flex-wrap: nowrap;
        }

        .game{
            display: flex;
            flex-direction: column;
            flex-wrap: wrap;
            align-items: center;
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
                <li><a href="matches">Завершеные матчи</a></li>
                <li><a href="new-match">Начать новый матч</a></li>
            </ul>
        </div>
    </div>
</header>
<div class="game">
    <table class="table_dark">
        <tr>
            <th>Имена игроков</th>
            <th>Сет</th>
            <th>Гейм</th>
            <th>Очки</th>
        </tr>
        <tr>
            <td>${requestScope.player1.name}</td>
            <td>${requestScope.scoreBoardPlayer1.seth}</td>
            <td>${requestScope.scoreBoardPlayer1.game}</td>
            <td>${requestScope.scoreBoardPlayer1.point}</td>
        </tr>
        <tr>
            <td>${requestScope.player2.name}</td>
            <td>${requestScope.scoreBoardPlayer2.seth}</td>
            <td>${requestScope.scoreBoardPlayer2.game}</td>
            <td>${requestScope.scoreBoardPlayer2.point}</td>
        </tr>
    </table>
    <div class="buttons">
        <form action="match-score?uuid=${requestScope.uuid}&id=${requestScope.player1.id}" method="post">
            <button class="custom-btn btn-7"><span>Выйграл первый игрок</span></button>
        </form>
        <form action="match-score?uuid=${requestScope.uuid}&id=${requestScope.player2.id}" method="post">
            <button class="custom-btn btn-7"><span>Выйграл второй игрок</span></button>
        </form>
    </div>
</div>



</body>
</html>