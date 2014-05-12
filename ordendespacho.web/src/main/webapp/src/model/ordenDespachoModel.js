define(['model/_ordenDespachoModel'], function() {
    App.Model.OrdenDespachoModel = App.Model._OrdenDespachoModel.extend({

    });

    App.Model.OrdenDespachoList = App.Model._OrdenDespachoList.extend({
        model: App.Model.OrdenDespachoModel
    });

    return  App.Model.OrdenDespachoModel;

});