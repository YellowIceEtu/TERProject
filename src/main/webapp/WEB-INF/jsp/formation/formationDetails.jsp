<%@ include file="/WEB-INF/jsp/header.jsp"%>
<div>
    <%@ include file="/WEB-INF/jsp/nav.jsp"%>
</div>

<c:url var="edit" value="formationDetails/edit" />


<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="formationCard">
    <div class="card">
        <p class="title"><c:out value="Date de création" /></p>
        <p> <c:out value="${formation.dateCrea}" /> </p>
        <p class="title"><c:out value="Date de modification" /></p>
        <p> <c:out value="${formation.dateMaj}" /> </p>
        <p class="title"><c:out value="Intitulé" /></p>
        <p><c:out value="${formation.intitule}" /></p>
        <p class="title"><c:out value="Code formation" /></p>
        <p><c:out value="${formation.code}" /></p>
        <p class="title"><c:out value="Etat d'edition" /></p>
        <p> <c:out value="${formation.etatEdition}" /> </p>
        <p class="title"><c:out value="Objectif" /></p>
        <p><c:out value="${formation.objectif}" /></p>
        <p class="title"><c:out value="Action" /></p>
        <p><c:out value="${formation.action.nom}" /></p>
    </div>
</div>

<p>
    <a class="btn btn-info" href="${edit}?id=${formation.id}">Modifier la Formation</a>
</p>


<%@ include file="/WEB-INF/jsp/footer.jsp"%>
