define(['model/_inventarioModel'], function() {
    App.Model.InventarioModel = App.Model._InventarioModel.extend({

    });

    App.Model.InventarioList = App.Model._InventarioList.extend({
        model: App.Model.InventarioModel
    });

    return  App.Model.InventarioModel;

});