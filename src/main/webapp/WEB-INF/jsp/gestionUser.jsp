<%@ include file="/WEB-INF/jsp/header.jsp"%>
<div>
    <%@ include file="/WEB-INF/jsp/nav.jsp"%>
</div>

<c:url var="addAdmini" value="/admin/gestionUtilisateur/addAdmin" />
<c:url var="addCorres" value="/admin/gestionUtilisateur/addCorrespondant" />


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<div class="container">


    <table class="table">
        <h1> Liste des administrateurs : </h1>
        <thead>
        <tr>
            <th scope="col">Nom</th>
            <th scope="col">Prénom</th>
        </tr>
        <thead>
        <tbody>
        <c:forEach items="${composante}" var="composante">
            <c:forEach items="${composante.correspondant}" var="utilisateur">
                <td><c:out value="${utilisateur.nom}" /></td>
                <td><c:out value="${utilisateur.prenom}" /></td>

            <tr>
                <td></td>
                <td></td>

                <td><a href=#">Supprimer</a></td>
            </tr>
            </c:forEach>
        </c:forEach>

        </tbody>
    </table>

    <table class="table">
        <h1> Liste des correspondants d'une composante :  </h1>
        <thead>
        <tr>
            <th scope="col">Nom</th>
            <th scope="col">Prénom</th>
        </tr>
        </thead>
        <tbody>

            <tr>
                <td></td>
                <td></td>
                <td><a href=#">Supprimer</a></td>
            </tr>

        </tbody>
    </table>

    <button class="ajouter-admin-button"><a href="${addAdmini}">Ajouter un administrateur</a></button>
    <button class="ajouter-correspondant-button"><a href="${addCorres}">Ajouter un correspondant</a></button>

</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
