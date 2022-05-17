<%@ include file="/WEB-INF/jsp/header.jsp"%>



<div>
    <%@ include file="/WEB-INF/jsp/nav.jsp"%>
</div>

<div class="container">
    <h1>Formations  </h1>

    <table class="table">

        <tr>
            <th>codeFormation :</th>
            <th>etatEdition :</th>
            <th> Intitule :</th>
        </tr>

        <tr>    <c:forEach items="${formation}" var="formation">

            <td><c:out value="${formation.intitule}" /></td>
            <td><c:out value="${formation.codeFormation}" /></td>
            <td><c:out value="${formation.etatEdition}" /></td>

        </tr>
        </c:forEach>






    </table>





</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
