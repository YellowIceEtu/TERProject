<%@ include file="/WEB-INF/jsp/header.jsp"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">
    <h1>Edit Formation</h1>
    <p class="title"><c:out value="Code formation" /></p>
    <p><c:out value="${formation.code}" /></p>
    <p class="title"><c:out value="Etat d'edition" /></p>
    <p> <c:out value="${formation.etatEdition}" /> </p>

    <form:form method="POST" modelAttribute="formation">



        <div class="form-group">
            <label for="intitule">Intitule :</label>
            <form:input path="intitule" class="form-control" />
            <form:errors path="intitule" cssClass="alert alert-warning"
                         element="div" />
        </div>
        <div class="form-group">
            <label for="objectif">Objectif :</label>
            <form:textarea class="form-control" path="objectif" rows="4" />
            <form:errors path="objectif" cssClass="alert alert-warning"
                         element="div" />
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-info">Submit</button>
        </div>
    </form:form>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
