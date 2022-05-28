<%@ include file="/WEB-INF/jsp/header.jsp"%>
<div>
    <%@ include file="/WEB-INF/jsp/nav.jsp"%>
</div>


<c:url var="view" value="/admin/listCorrespondant" />


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">

    <h1>Liste des correspondants </h1>

    <table class="table">
        <tr>
            <th scope="col">Nom</th>
            <th scope="col">Prénom</th>
            <th scope="col">Composante</th>
            <th scope="col">Administrateur</th>
        </tr>
        <c:forEach items="${composante}" var="composante">
            <c:forEach items="${composante.correspondant}" var="utilisateur">
                <tr>
                <th scope="row">${utilisateur.id}</th>
                <td><c:out value="${utilisateur.nom}" /></td>
                <td><c:out value="${utilisateur.prenom}" /></td>
                <td><c:out value="${utilisateur.composante}" /></td>
                <td><c:out value="${utilisateur.estAdmin}" /></td>

            </c:forEach>


        </c:forEach>

    </table>

</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>