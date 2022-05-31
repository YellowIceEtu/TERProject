<%@ include file="/WEB-INF/jsp/header.jsp"%>
<div>
    <%@ include file="/WEB-INF/jsp/nav.jsp"%>
</div>

<c:url var="addAdmini" value="/admin/gestionUtilisateur/addAdmin" />
<c:url var="addCorres" value="/admin/gestionUtilisateur/addCorrespondant" />
<c:url var="suppr" value="/deleteUser" />

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<div class="container">






    <table class="table">
        <h1> Liste des administrateurs :  </h1>
        <thead>
        <tr>
            <th scope="col">Nom</th>
            <th scope="col">Prénom</th>
            <th scope="col">Administrateur</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <c:forEach items="${utilisateur}" var="utilisateur">
                <c:choose>
            <c:when test="${utilisateur.admin == true}">
            <td><c:out value="${utilisateur.nom}" /></td>
            <td><c:out value="${utilisateur.prenom}" /></td>
            <td><c:out value="${utilisateur.admin}" /></td>
                <td><a href="${suppr}${utilisateur.id}">Supprimer</a></td>
        </tr>
        </c:when>
        </c:choose>
        </c:forEach>
        </tbody>
    </table>



    <table class="table">
        <h1> Liste des correspondants d'une composante :  </h1>
        <thead>
        <tr>
            <th scope="col">Nom</th>
            <th scope="col">Prénom</th>
            <th scope="col">Composante</th>

        </tr>
        </thead>
        <tbody>

        <tr>
    <c:forEach items="${utilisateur}" var="utilisateur">
        <c:choose>
            <c:when test="${utilisateur.idComposante != null}">


    <td><c:out value="${utilisateur.nom}" /></td>
    <td><c:out value="${utilisateur.prenom}" /></td>
    <td><c:out value="${utilisateur.idComposante.intitule}" /></td>
            <td><a href="${suppr}${utilisateur.id}">Supprimer</a></td>
        </tr>
        </c:when>
        </c:choose>
        </c:forEach>
        </tbody>
    </table>

    <button class="ajouter-admin-button"><a href="${addAdmini}">Ajouter un administrateur</a></button>
    <button class="ajouter-correspondant-button"><a href="${addCorres}">Ajouter un correspondant</a></button>

</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>