define([], function() {
    App.Model._OrdenReaprovicionamientoMasterModel = Backbone.Model.extend({
     
    });

    App.Model._OrdenReaprovicionamientoMasterList = Backbone.Collection.extend({
        model: App.Model._OrdenReaprovicionamientoMasterModel,
        initialize: function() {
        }

    });
    return App.Model._OrdenReaprovicionamientoMasterModel;
    
});