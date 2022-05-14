<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:url var="home" value="/" />
<c:url var="profiles" value="/profiles" />
<c:url var="log" value="/log" />
<c:url var="search" value="/result/find" />

<nav class="navbar">
    <div class="container-fluid">
        <a class="navbar-brand">CPF Manager</a>
        <div class="menu">
            <ul class="item-navbar">
                <li><a class="home" href="#">Home</a></li>

            </ul>
        </div>
            <form class="d-flex input-group w-auto">
                <input
                    type="search"
                    class="form-control rounded"
                    placeholder="Search"
                    aria-label="Search"
                    aria-describedby="search-addon"
                    />
                <span class="input-search" id="search-addon">
               <button>Find</button>
                </span>
            </form>

    </div>
</nav>
