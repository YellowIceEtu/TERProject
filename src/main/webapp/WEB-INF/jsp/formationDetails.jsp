<%@ include file="/WEB-INF/jsp/header.jsp"%>


<div>
    <%@ include file="/WEB-INF/jsp/nav.jsp"%>
</div>

<div class="personCard">
    <div class="card">
        <p>Intitule de la formation : <c:out value="${formation.intitule}" /></p>
        <p>Code de la formation : <c:out value="${formation.codeFormation}" /></p>
        <p>Etat edition : <c:out value="${formation.etatEdition}" /> </p>


    </div>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
