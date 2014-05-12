define(['model/_ordenFabricacionModel'], function() {
    App.Model.OrdenFabricacionModel = App.Model._OrdenFabricacionModel.extend({

    });

    App.Model.OrdenFabricacionList = App.Model._OrdenFabricacionList.extend({
        model: App.Model.OrdenFabricacionModel
    });

    return  App.Model.OrdenFabricacionModel;

});