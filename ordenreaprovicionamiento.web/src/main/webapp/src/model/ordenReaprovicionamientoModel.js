define(['model/_ordenReaprovicionamientoModel'], function() {
    App.Model.OrdenReaprovicionamientoModel = App.Model._OrdenReaprovicionamientoModel.extend({

    });

    App.Model.OrdenReaprovicionamientoList = App.Model._OrdenReaprovicionamientoList.extend({
        model: App.Model.OrdenReaprovicionamientoModel
    });

    return  App.Model.OrdenReaprovicionamientoModel;

});