define(['model/_facturaModel'], function() {
    App.Model.FacturaModel = App.Model._FacturaModel.extend({

    });

    App.Model.FacturaList = App.Model._FacturaList.extend({
        model: App.Model.FacturaModel
    });

    return  App.Model.FacturaModel;

});