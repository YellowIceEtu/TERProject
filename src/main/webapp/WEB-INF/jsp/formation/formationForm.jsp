<%@ include file="/WEB-INF/jsp/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">
    <h1>Edit Formation</h1>
    <p class="title"><c:out value="Composante :" /></p>
    <p><c:out value="${formation.composante.intitule}" /></p>
    <p class="title"><c:out value="Code formation :" /></p>
    <p><c:out value="${formation.code}" /></p>
    <p class="title"><c:out value="Etat d'édition :" /></p>
    <p> <c:out value="${formation.etatEdition}" /> </p>
    <p class="title"><c:out value="Code CERTIFINFO :" /></p>
    <p> <c:out value="${formation.CERTIFINFO}" /> </p>

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
            <label for="resultatsAttendus">résultats attendus :</label>
            <form:textarea class="form-control" path="resultatsAttendus" rows="4" />
            <form:errors path="resultatsAttendus" cssClass="alert alert-warning"
                         element="div" />
        </div>
        <div class="form-group">
            <label for="contenu">Contenu :</label>
            <form:textarea class="form-control" path="contenu" rows="4" />
            <form:errors path="contenu" cssClass="alert alert-warning"
                         element="div" />
        </div>
<%--        <div class="form-group">--%>
<%--            <label for="typeParcours">Type de parcours CHANGER EN LISTE DEROULANTE:</label>--%>
<%--            <form:textarea class="form-control" path="typeParcours" rows="1" />--%>
<%--            <form:errors path="typeParcours" cssClass="alert alert-warning"--%>
<%--                         element="div" />--%>
<%--        </div>--%>
        <div class="form-group">
            <label for="typeParcours">Choisissez un type de parcours :</label>
            <form:select path="typeParcours" multiple="false" class="form-control">
                <form:option value="" label="--- Select ---" />
                <form:options items="${typeDeParcours}" />
            </form:select>
            <form:errors path="typeParcours" cssClass="alert alert-warning"
                         element="div" />
        </div>
        <div class="form-group">
            <label for="objectif">Objectif de la formation :</label>
            <form:select path="objectif" multiple="false" class="form-control">
                <form:option value="" label="--- Select ---" />
                <form:options items="${objectif}" />
            </form:select>
            <form:errors path="objectif" cssClass="alert alert-warning"
                         element="div" />
        </div>
        <div class="form-group">
            <label for="action.niveauObligatoire">niveau obligatoire requis  :</label>
            non <form:radiobutton path="action.niveauObligatoire" value="0"/>
            oui <form:radiobutton path="action.niveauObligatoire" value="1"/>
            <form:errors path="action.niveauObligatoire" cssClass="alert alert-warning" element="div" />
        </div>
<%--        <div class="form-group">--%>
<%--            <label for="action.modaliteEnseignement">Modalités d'enseignement CHANGER EN LISTE DEROULANTE:</label>--%>
<%--            <form:textarea class="form-control" path="action.modaliteEnseignement" rows="1" />--%>
<%--            <form:errors path="action.modaliteEnseignement" cssClass="alert alert-warning"--%>
<%--                         element="div" />--%>
<%--        </div>--%>
        <div class="form-group">
            <label for="action.modaliteEnseignement">Modalités d'enseignement :</label>
            <form:select path="action.modaliteEnseignement" multiple="false" class="form-control">
                <form:option value="" label="--- Select ---" />
                <form:options items="${modaliteEnseignement}" />
            </form:select>
            <form:errors path="action.modaliteEnseignement" cssClass="alert alert-warning"
                         element="div" />
        </div>
<%--        <div class="form-group">--%>
<%--            <label for="action.rythmeFormation">rythme de formation CHANGER EN LISTE DEROULANTE MULTICHOIX:</label>--%>
<%--            <form:textarea class="form-control" path="action.rythmeFormation" rows="1" />--%>
<%--            <form:errors path="action.rythmeFormation" cssClass="alert alert-warning"--%>
<%--                         element="div" />--%>
<%--        </div>--%>
        <div class="form-group">
            <label for="action.rythmeFormation">Rythme de formation :</label>
            <form:select path="action.rythmeFormation" multiple="true" class="form-control">
                <form:option value="" label="--- Select ---" />
                <form:options items="${rythmeFormation}" />
            </form:select>
            <form:errors path="action.rythmeFormation" cssClass="alert alert-warning"
                         element="div" />
        </div>
        <div class="form-group">
            <label for="action.conditionsSpecifiques">Conditions spécifiques :</label>
            <form:textarea class="form-control" path="action.conditionsSpecifiques" rows="4" />
            <form:errors path="action.conditionsSpecifiques" cssClass="alert alert-warning"
                         element="div" />
        </div>
        <div class="form-group">
            <label for="action.modaliteEntreeSortie">Modalités d'entrée/sortie :</label>
            A dates fixes <form:radiobutton path="action.modaliteEntreeSortie" value="0"/>
            Permanentes (sans dates fixes)<form:radiobutton path="action.modaliteEntreeSortie" value="1"/>
            <form:errors path="action.modaliteEntreeSortie" cssClass="alert alert-warning"
                         element="div" />
        </div>
        <div class="form-group">
            <label for="action.url">URL de la formation :</label>
            <form:textarea class="form-control" path="action.url" rows="1" />
            <form:errors path="action.url" cssClass="alert alert-warning"
                         element="div" />
        </div>
        <div class="form-group">
            <label for="action.restauration">Précisions sur la restauration :</label>
            <form:textarea class="form-control" path="action.restauration" rows="1" />
            <form:errors path="action.restauration" cssClass="alert alert-warning"
                         element="div" />
        </div>
        <div class="form-group">
            <label for="action.hebergement">Précisions sur l'hébergement :</label>
            <form:textarea class="form-control" path="action.hebergement" rows="2" />
            <form:errors path="action.hebergement" cssClass="alert alert-warning"
                         element="div" />
        </div>
        <div class="form-group">
            <label for="action.transport">Précisions sur les transports  :</label>
            <form:textarea class="form-control" path="action.transport" rows="2" />
            <form:errors path="action.transport" cssClass="alert alert-warning"
                         element="div" />
        </div>
        <div class="form-group">
            <label for="action.accesHandicapes">Précisions sur l'accès aux handicapés :</label>
            <form:textarea class="form-control" path="action.accesHandicapes" rows="2" />
            <form:errors path="action.accesHandicapes" cssClass="alert alert-warning"
                         element="div" />
        </div>
<%--        <div class="form-group">--%>
<%--            <label for="action.langueFormation">Langue de la formation CHANGER EN LISTE DEROULANTE MULTICHOIX:</label>--%>
<%--            <form:textarea class="form-control" path="action.langueFormation" rows="1" />--%>
<%--            <form:errors path="action.langueFormation" cssClass="alert alert-warning"--%>
<%--                         element="div" />--%>
<%--        </div>--%>
        <div class="form-group">
            <label for="action.langueFormation">Langue de la formation :</label>
            <form:select path="action.langueFormation" multiple="false" class="form-control">
                <form:option value="" label="--- Select ---" />
                <form:options items="${langueFormation}" />
            </form:select>
            <form:errors path="action.langueFormation" cssClass="alert alert-warning"
                         element="div" />
        </div>
        <div class="form-group">
            <label for="action.modaliteRecrutement">Modalités de recrutement :</label>
            <form:textarea class="form-control" path="action.modaliteRecrutement" rows="4" />
            <form:errors path="action.modaliteRecrutement" cssClass="alert alert-warning"
                         element="div" />
        </div>
        <div class="form-group">
            <label for="action.nombreHeureCentre">Nombre d'heures en centre de formation :</label>
            <form:textarea class="form-control" path="action.nombreHeureCentre" rows="2" />
            <form:errors path="action.nombreHeureCentre" cssClass="alert alert-warning"
                         element="div" />
        </div>
        <div class="form-group">
            <label for="action.nombreHeureEntreprise">Nombre d'heures en entreprise :</label>
            <form:textarea class="form-control" path="action.nombreHeureEntreprise" rows="2" />
            <form:errors path="action.nombreHeureEntreprise" cssClass="alert alert-warning"
                         element="div" />
        </div>
        <div class="form-group">
            <label for="action.modalitesHandicap">Modalités handicap :</label>
            <form:textarea class="form-control" path="action.modalitesHandicap" rows="4" />
            <form:errors path="action.modalitesHandicap" cssClass="alert alert-warning"
                         element="div" />
        </div>
<%--        <div class="form-group">--%>
<%--            <label for="action.modaliteAdmission">Modalités d'admission CHANGER EN LISTE DEROULANTE MULTICHOIX:</label>--%>
<%--            <form:textarea class="form-control" path="action.modaliteAdmission" rows="1" />--%>
<%--            <form:errors path="action.modaliteAdmission" cssClass="alert alert-warning"--%>
<%--                         element="div" />--%>
<%--        </div>--%>
        <div class="form-group">
            <label for="action.modaliteAdmission">Modalités d'admission :</label>
            <form:select path="action.modaliteAdmission" multiple="false" class="form-control">
                <form:option value="" label="--- Select ---" />
                <form:options items="${modaliteAdmission}" />
            </form:select>
            <form:errors path="action.modaliteAdmission" cssClass="alert alert-warning"
                         element="div" />
        </div>
        <div class="form-group">
            <label for="action.infosAdmission">Informations d'admission :</label>
            <form:textarea class="form-control" path="action.infosAdmission" rows="2" />
            <form:errors path="action.infosAdmission" cssClass="alert alert-warning"
                         element="div" />
        </div>
        <div class="form-group">
            <label for="action.fraisANPEC">Frais ANPEC :</label>
            <form:textarea class="form-control" path="action.fraisANPEC" rows="1" />
            <form:errors path="action.fraisANPEC" cssClass="alert alert-warning"
                         element="div" />
        </div>
        <div class="form-group">
            <label for="action.fraisInclusANPEC">Frais ANPEC inclus dans le coût d'inscription :</label>
            non <form:radiobutton path="action.fraisInclusANPEC" value="0"/>
            oui <form:radiobutton path="action.fraisInclusANPEC" value="1"/>
            <form:errors path="action.fraisInclusANPEC" cssClass="alert alert-warning"
                         element="div" />
        </div>
<%--        <div class="form-group">--%>
<%--            <label for="action.tauxTVA">Taux TVA CHANGER EN LISTE DEROULANTE MULTICHOIX:</label>--%>
<%--            <form:textarea class="form-control" path="action.tauxTVA" rows="1" />--%>
<%--            <form:errors path="action.tauxTVA" cssClass="alert alert-warning"--%>
<%--                         element="div" />--%>
<%--        </div>--%>
        <div class="form-group">
            <label for="action.tauxTVA">Taux TVA :</label>
            <form:select path="action.tauxTVA" multiple="false" class="form-control">
                <form:option value="" label="--- Select ---" />
                <form:options items="${tauxTVA}" />
            </form:select>
            <form:errors path="action.tauxTVA" cssClass="alert alert-warning"
                         element="div" />
        </div>
        <div class="form-group">
            <label for="action.fraisHT">Frais hors taxe :</label>
            <form:textarea class="form-control" path="action.fraisHT" rows="1" />
            <form:errors path="action.fraisHT" cssClass="alert alert-warning"
                         element="div" />
        </div>
        <div class="form-group">
            <label for="action.fraisTTC">Frais toutes taxes comprises :</label>
            <form:textarea class="form-control" path="action.fraisTTC" rows="1" />
            <form:errors path="action.fraisTTC" cssClass="alert alert-warning"
                         element="div" />
        </div>
        <div class="form-group">
            <label for="action.preRequis">Existence de pré-requis :</label>
            non <form:radiobutton path="action.preRequis" value="0"/>
            oui <form:radiobutton path="action.preRequis" value="1"/>
            <form:errors path="action.preRequis" cssClass="alert alert-warning"
                         element="div" />
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-info">Submit</button>
        </div>
    </form:form>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
