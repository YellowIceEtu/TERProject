<%@ include file="/WEB-INF/jsp/header.jsp"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">
    <h1>Ajout d'un correspondant</h1>

    <form:form method="POST" modelAttribute="utilisateur" >



        <div class="form-group">
            <label for="nom"> Tapez le nom : </label>
            <form:input path="nom" class="form-control" />
            <form:errors path="nom" cssClass="alert alert-warning" element="div" />
        </div>

        <div class="form-group">
            <label for="prenom"> Tapez le prénom : </label>
            <form:input path="prenom" class="form-control" />
            <form:errors path="prenom" cssClass="alert alert-warning" element="div" />
        </div>

        <div class="form-group">
            <%--@declare id="composante"--%><label for="idComposante"> choisissez une composante : </label>
            <form:select path="idComposante">
                <form:option value="">Select</form:option>
                <form:options items="${ListComposantes}" />
            </form:select>

        </div>

        <div class="form-group">
            <button type="submit" class="btn btn-info">Submit</button>
        </div>
    </form:form>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
