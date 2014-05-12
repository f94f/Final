define(['model/_ordenDespachoMasterModel'], function() { 
    App.Model.OrdenDespachoMasterModel = App.Model._OrdenDespachoMasterModel.extend({
		initialize: function() {
            this.on('invalid', function(model,error) {
                Backbone.trigger('ordenDespacho-master-model-error', error);
            });
        },
        validate: function(attrs, options){
        	var modelMaster = new App.Model.OrdenDespachoModel();
        	if(modelMaster.validate){
            	return modelMaster.validate(attrs.ordenDespachoEntity,options);
            }
        }
    });

    App.Model.OrdenDespachoMasterList = App.Model._OrdenDespachoMasterList.extend({
        model: App.Model.OrdenDespachoMasterModel
    });

    return  App.Model.OrdenDespachoMasterModel;

});