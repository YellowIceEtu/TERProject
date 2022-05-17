<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:url var="home" value="/" />

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <a class="navbar-brand">CPF Manager</a>
        <form class="right-navbar">

            <button class="admin-button"><a href=#>Admin</a></button>
            <button class="composante-button"><a href=#>Composante</a></button>
            <input
                    type="search"
                    class="input-search"
                    placeholder="Search"
                    aria-label="Search"
                    aria-describedby="search-addon"
            />

               <button class="search-button">Find</button>


            <button class="logout-button"><a href='logout/cas'>Logout</a></button>
        </form>

    </div>
</nav>
