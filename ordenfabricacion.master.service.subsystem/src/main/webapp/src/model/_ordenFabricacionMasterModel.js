define([], function() {
    App.Model._OrdenFabricacionMasterModel = Backbone.Model.extend({
     
    });

    App.Model._OrdenFabricacionMasterList = Backbone.Collection.extend({
        model: App.Model._OrdenFabricacionMasterModel,
        initialize: function() {
        }

    });
    return App.Model._OrdenFabricacionMasterModel;
    
});