<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:url var="home" value="/" />

<nav class="nav-bar">
    <div class="nav-title">
        <a  href="${home}">
            CPF Manager
        </a>

    </div>


    <div class="nav-search" >
        <form action="${search}" id="searchForm" >
            <button class="btnSearchInput" type="button"><i class="fas fa-search"></i></button>
            <input  class="searchInput" type="search" placeholder="Rechercher..." aria-label="Search" name="name">
        </form>
    </div>
</nav>