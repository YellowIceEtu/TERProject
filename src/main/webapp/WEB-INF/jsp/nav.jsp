<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:url var="home" value="/" />
<c:url var="adminhref" value="/admin" />
<c:url var="correspondanthref" value="/correspondant" />

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-title">
        <a href="http://localhost:8081/formationList" class="navbar-brand">CPF Manager</a>
        </div>
        <form class="right-navbar">


            <button class="admin-button"><a href="${adminhref}">Admin</a></button>
            <button class="composante-button"><a href="${correspondanthref}">Composante</a></button>
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
