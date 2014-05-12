define([], function() {
    App.Model._InventarioMasterModel = Backbone.Model.extend({
     
    });

    App.Model._InventarioMasterList = Backbone.Collection.extend({
        model: App.Model._InventarioMasterModel,
        initialize: function() {
        }

    });
    return App.Model._InventarioMasterModel;
    
});