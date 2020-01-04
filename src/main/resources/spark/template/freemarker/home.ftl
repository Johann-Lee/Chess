<!DOCTYPE html>
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
  <meta http-equiv="refresh" content="10">
  <title>Web Chess | ${title}</title>
  <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>


<body class="bground">


    <!-- Edit under this if condition for when a player is logged in -->
    <#if currentUser??>
        <h1 class="header2"> <u> LOBBY </u> </h1>

        <div id="options">
            <ul class="nav">
              <li class="nav_element"><a class="active">Home</a></li>

              <li class="nav_element"><a href="#archive">Archived Games</a></li>

              <li class="nav_element"><a href="https://en.wikipedia.org/wiki/Rules_of_chess" target="_blank">Rules</a></li>

              <li class="nav_element" style="float:right;margin-right:30px">


               <form id="signout" action="/" method="post">
                <a href="#" onclick="event.preventDefault(); signout.submit();"> SIGN OUT [${currentUser.getUsername()}]</a>
               </form>

               </li>
            </ul>
        </div>

        <br></br>
        <br></br>

        <div>

        <h1 style="font-size:40px;color:white"> Player(s) Online <h1>

        <ul style="color:white;float:left">
        <#list lobby as user>

                <form id="game" action="/game" method="get">
                  <li > <button style="border-radius:12px"> ${user.getUsername()} </button> </li>
                </form>

                <br></br>
        </#list>
        </ul>
        </div>




    <!-- Edit under this else condition for when a player is not logged in -->
    <#else>
        <h1 class="header"> <u> ${title} </u> </h1>


        <div class="column left">
                <ul>

                    <form action="/signin" method="GET">
                        <li> <button name= "signin" class="button div-button"> Sign In </button> </li>
                    </form>

                    <li> <button class="button div-button"> Sign Up </button> </li>
                 </ul>
        </div>

        <div class="column right">
            <h1 style="color:white"> <em> The Game </em> <h1>
            <p style="color:white"> Chess is a two-player strategy board game played on a checkered board with 64 squares arranged in an 8×8 grid.
             The game is played by millions of people worldwide. Chess is believed to be derived from the Indian game chaturanga sometime before the 7th century. </p>
        </div>

        <br></br>


        <div class="footer">

            <#if lobby??>
                <h2>Players Online Right Now : <span style= "color:white"> ${playerCount} </span> </h2>
            <#else>
                <h2>Players Online Right Now : 0</h2>
            </#if>

        </div>

    </#if>


</body>

</html>