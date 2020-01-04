<!DOCTYPE html>
<html>

<!-- Metadata -->
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
  <title>Web Chess | ${title}</title>
  <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>

<body class="bground">

    <div id="center_align">

            <h2 class="signin" > Sign in </h2>
            <br></br>
            <div class="dialogbox">
                <form action="/signin" method="post">
                    <label> Username: <input name="username" type="text"> </label>
                    <button>Submit</button>
                </form>
            </div>
            <br></br>
            <div>
                <p> Don't have an account? </p>
                <form action="/signup" method="get">
                    <button name="signup" type="submit" class="linkButton"> Sign Up! </button>
                </form>
            </div>

    </div>

</body>


<html>
