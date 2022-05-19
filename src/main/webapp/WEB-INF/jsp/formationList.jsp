<%@ include file="/WEB-INF/jsp/header.jsp"%>


<c:url var="view" value="/formationDetails" />
<c:url var="edit" value="formationDetails/edit" />

<div>
    <%@ include file="/WEB-INF/jsp/nav.jsp"%>
</div>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <h1>Formations  </h1>

    <table class="table">

        <tr>
            <th> Intitulé :</th>
            <th>Code formation :</th>
            <th>État d'édition :</th>
            <th> Détails : </th>
        </tr>

        <tr>
            <c:forEach items="${formation}" var="formation">
            <td><c:out value="${formation.intitule}" /></td>
            <td><c:out value="${formation.codeFormation}" /></td>
            <td><c:out value="${formation.etatEdition}" /></td>
                <td> <a href="${view}?id=${formation.id}"> <i class="fas fa-eye"></i></a></td>

        </tr>
        </c:forEach>






    </table>





</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
