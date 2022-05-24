<%@ include file="/WEB-INF/jsp/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">
    <h1>Edit Formation</h1>
    <p class="title"><c:out value="Intitulé : " /><c:out value="${formation.intitule}" /></p>
    <p class="title"><c:out value="Code formation : " /><c:out value="${formation.code}" /></p>
    <p class="title"><c:out value="Etat d'edition : " /> <c:out value="${formation.etatEdition}" /> </p>
    <p class="title"><c:out value="Code CERIFINFO : " /> <c:out value="${formation.CERTIFINFO}" /> </p>

    <form:form method="POST" modelAttribute="formation">

        <form:errors path="*" cssClass="alert alert-danger" element="div" />
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
