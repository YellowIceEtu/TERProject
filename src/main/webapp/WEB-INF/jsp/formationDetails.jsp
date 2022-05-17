<%@ include file="/WEB-INF/jsp/header.jsp"%>



<div>
    <%@ include file="/WEB-INF/jsp/nav.jsp"%>
</div>

<div class="personCard">
    <div class="card">
        <p><c:out value="${formation.codeFormation}" /></p>
        <p> <c:out value="${formation.etatEdition}" /> </p>
        <p><c:out value="${formation.intitule}" /></p>


    </div>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
