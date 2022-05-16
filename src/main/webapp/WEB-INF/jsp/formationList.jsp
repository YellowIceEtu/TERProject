<%@ include file="/WEB-INF/jsp/header.jsp"%>



<div>
    <%@ include file="/WEB-INF/jsp/nav.jsp"%>
</div>

<div class="container">
    <h1>Formations  </h1>
    <p><a href='logout/cas'>Logout</a></p>
    <table class="table table-hover">

        <tr>
            <td>codeFormation :</td>
            <td>etatEdition :</td>
            <td> Intitule :</td>
        <tr>

            <c:forEach items="${formation}" var="formation">
        <tr>
            <td><c:out value="${formation.intitule}" /></td>
            <td><c:out value="${formation.codeFormation}" /></td>
            <td><c:out value="${formation.etatEdition}" /></td>

        </tr>
        </c:forEach>


        </tr>



    </table>





</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
