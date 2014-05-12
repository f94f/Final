define([], function() {
    App.Model._InventarioModel = Backbone.Model.extend({
        defaults: {
 
		 'name' : ''        },
        initialize: function() {
        },
        getDisplay: function(name) {
         return this.get(name);
        }
    });

    App.Model._InventarioList = Backbone.Collection.extend({
        model: App.Model._InventarioModel,
        initialize: function() {
        }

    });
    return App.Model._InventarioModel;
});