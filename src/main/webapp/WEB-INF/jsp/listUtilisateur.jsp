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
        <thead>
        <tr>
            <th scope="col">Nom</th>
            <th scope="col">Prénom</th>
            <th scope="col">Composante</th>
            <th scope="col">Administrateur</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${utilisateurs}" var="utilisateur">
                <tr>
                <td><c:out value="${utilisateur.nom}" /></td>
                <td><c:out value="${utilisateur.prenom}" /></td>
                <td><c:out value="${utilisateur.composante.intitule}" /></td>
                    <td><c:out value="${utilisateur.estAdmin}" /></td>
                <td><a  href="/admin/editRoleUser/${utilisateur.id}"role="submit"> Attribuer un nouveau role </a></td>

                </tr>
            </c:forEach>


        </tbody>
    </table>

</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>