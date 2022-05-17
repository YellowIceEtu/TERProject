<%@ include file="/WEB-INF/jsp/header.jsp"%>



<div>
    <%@ include file="/WEB-INF/jsp/nav.jsp"%>
</div>

<div class="container">
    <h1> Details de la formation </h1>


    <p>
        codeFormation:
        <c:out value="${formation.codeFormation}" />
    </p>
    <p>
        Etat Edition :
        <c:out value="${formation.etatEdition}" />
    </p>
    <p>
        Intitule :
        <c:out value="${formation.intitule}" />
    </p>






</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
