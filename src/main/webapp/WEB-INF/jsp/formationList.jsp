<%@ include file="/WEB-INF/jsp/header.jsp"%>


<c:url var="view" value="/formationDetails" />

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
            <th> IdFormation :</th>
            <th> Profile : </th>
        </tr>

        <tr>    <c:forEach items="${formation}" var="formation">

            <td><c:out value="${formation.intitule}" /></td>
            <td><c:out value="${formation.codeFormation}" /></td>
            <td><c:out value="${formation.etatEdition}" /></td>
            <td><c:out value="${formation.idFormation}" /></td>
            <td> <a href="${view}?id=${formation.codeFormation}"> <i class="fas fa-eye"></i></a></td>

        </tr>
        </c:forEach>






    </table>





</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
