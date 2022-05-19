<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/WEB-INF/jsp/header.jsp"%>



<div>
    <%@ include file="/WEB-INF/jsp/nav.jsp"%>
</div>

<div class="formationCard">
    <div class="card">
        <p class="title"><c:out value="Intitulé" /></p>
        <p><c:out value="${formation.intitule}" /></p>
        <p class="title"><c:out value="Code formation" /></p>
        <p><c:out value="${formation.codeFormation}" /></p>
        <p class="title"><c:out value="Etat d'edition" /></p>
        <p> <c:out value="${formation.etatEdition}" /> </p>
        <p class="title"><c:out value="Date de création" /></p>
        <p> <c:out value="${formation.dateCrea}" /> </p>



    </div>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
