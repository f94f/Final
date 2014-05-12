define([], function() {
    App.Model._OrdenDespachoMasterModel = Backbone.Model.extend({
     
    });

    App.Model._OrdenDespachoMasterList = Backbone.Collection.extend({
        model: App.Model._OrdenDespachoMasterModel,
        initialize: function() {
        }

    });
    return App.Model._OrdenDespachoMasterModel;
    
});