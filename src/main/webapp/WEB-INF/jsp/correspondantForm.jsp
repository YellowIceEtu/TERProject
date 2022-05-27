<%@ include file="/WEB-INF/jsp/header.jsp"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">
    <h1>Ajout d'un correspondant</h1>

    <form:form method="POST" modelAttribute="utilisateur" >

        <form:errors path="*" cssClass="alert alert-danger" element="div" />

        <div class="form-group">
            <label for="nom"> Tapez le nom : </label>
            <form:input path="nom" class="form-control" />
            <form:errors path="nom" cssClass="alert alert-warning" element="div" />
        </div>

        <div class="form-group">
            <button type="submit" class="btn btn-info">Submit</button>
        </div>
    </form:form>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
